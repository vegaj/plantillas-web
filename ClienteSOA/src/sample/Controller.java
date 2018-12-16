package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import ws.Producto;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;
import static service.ProductoFacade.getInstance;

public class Controller implements Initializable {

    private enum OP {CREAR,EDITAR};

    @FXML
    private Button toolbarFindCaducadosBtn, toolbarFindAllBtn, toolbarCrearBtn;
    @FXML
    private TableView<Producto> tablaResultados;
    @FXML
    private TableColumn<Producto, Integer> colID;
    @FXML
    private TableColumn<Producto, String> colNombre;
    @FXML
    private TableColumn<Producto, String> colVendedor;
    @FXML
    private TableColumn<Producto, String> colDetalles;
    @FXML
    private TableColumn<Producto, String> colImg;
    @FXML
    private TableColumn<Producto, Float> colPrecio;
    @FXML
    private TableColumn<Producto, Integer> colCantidad;
    @FXML
    private TableColumn<Producto, XMLGregorianCalendar> colCaducidad;

    @FXML
    private Label notification;

    private Producto prod;
    private OP current;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeView();
        getInstance();
    }


    @FXML
    private DatePicker formCaducidadPicker;
    public void handleCaducados(ActionEvent event) {
        List<Producto> productos;
        toolbarFindCaducadosBtn.setDisable(true);
        try {
            XMLGregorianCalendar date = extractDate(formCaducidadPicker);
            productos = getInstance().findCaducados(date);
            setList(productos);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error Caducados");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        } finally {
            toolbarFindCaducadosBtn.setDisable(false);
        }
    }

    public void handleFormularioCrear() {
        this.prod = new Producto();
        this.prod.setVendedor("System");
        this.prod.setId(0);
        this.prod.setImagen("");
        this.cambiaProductoActual(prod);
    }

    public void handleBorrar() {
        if(this.prod == null || this.prod.getId() == null || this.prod.getId() <= 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Atención al Borrar");
            alert.setContentText("El producto no es válido para ser borrado");
            alert.showAndWait();
            return;
        }
        try {
            getInstance().removeProduct(this.prod);
            notification.setText("Producto borrado!");
            setList(getInstance().findAll());
            this.prod = new Producto();
            cambiaProductoActual(prod);
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error al Borrar");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }
    }

    @FXML
    private TextField crearNombre, crearPrecio, crearCantidad, crearImagen, crearVendedor;
    @FXML
    private TextArea crearDetalles;
    @FXML
    private DatePicker crearFecha;

    private void actualizaCrearFormulario(Producto p) {
        this.crearNombre.setText(p.getNombre());
        this.crearPrecio.setText(String.valueOf(p.getPrecio()));
        this.crearCantidad.setText(String.valueOf(p.getCantidad()));
        this.crearVendedor.setText(p.getVendedor());
        this.crearImagen.setText(p.getImagen());
        this.crearDetalles.setText(p.getDetalles());
        this.crearFecha.setValue(LocalDate.now());
    }


    public void handlePersist(ActionEvent event) {

        try {
            prod.setNombre(crearNombre.getText());
            prod.setVendedor(crearVendedor.getText());
            prod.setDetalles(crearDetalles.getText());
            prod.setPrecio(Double.parseDouble(crearPrecio.getText()));
            prod.setCantidad(Integer.parseInt(crearCantidad.getText()));
            prod.setCaducidad(extractDate(crearFecha));
            prod.setImagen(crearImagen.getText());
        } catch (Exception e) {
            notification.setText("Algunos campos inválidos");
            return;
        }

        try {
            if (current == OP.CREAR)
                getInstance().crear(prod);
            if (current == OP.EDITAR)
                getInstance().editar(prod);

            this.prod = new Producto();
            this.current = OP.CREAR;

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Fallo al guardar");
            alert.setContentText(e.getMessage());
            notification.setText(e.getMessage());
            alert.showAndWait();
            return;
        }

        cambiaProductoActual(prod);
        setList(getInstance().findAll());
    }

    public void handleFindAll(ActionEvent event) {
        List<Producto> productos;
        toolbarFindAllBtn.setDisable(true);
        try {
             productos = getInstance().findAll();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Operation findAll Failed");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }finally {
            toolbarFindAllBtn.setDisable(false);
        }
        this.setList(productos);
    }

    private void setList(List<Producto> prod) {
        this.tablaResultados.getItems().setAll(prod);
    }

    @FXML
    private TextField vistaPrecio, vistaNombre, vistaCantidad, vistaVendedor;
    @FXML
    private TextArea vistaDetalles;
    @FXML
    private ImageView vistaImagen;
    @FXML
    private TextField vistaFecha;


    @FXML
    private ToolBar advancedToolbar;
    private void actualizaVistaPrevia(Producto p) {

        String nombre = p.getNombre(),
               vended = p.getVendedor(),
               imgurl = p.getImagen(),
               detall = p.getDetalles();

        vistaNombre.setText(nombre);
        vistaVendedor.setText(vended);
        vistaDetalles.setText(detall);
        vistaPrecio.setText(String.valueOf(p.getPrecio()));
        vistaCantidad.setText(String.valueOf(p.getCantidad()));
        try {
            vistaImagen.setImage(new Image(imgurl));
        } catch(Exception e) {
            notification.setText("Error al cargar imagen: " + e.getMessage());
        }

    }


    @FXML
    private Button submitBtn;
    public void cambiaProductoActual(Producto p) {

        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Producto nulo!");
            alert.setContentText("Se ha intentado trabajar con un producto nulo");
            alert.showAndWait();
            return;
        }

        prod = p;

        if(p.getId() != null && p.getId() > 0) {
            //El producto ya existe.
            advancedToolbar.setVisible(true);
            submitBtn.setText("Editar");
            current = OP.EDITAR;
        } else {
            //El  producto va a ser creado
            advancedToolbar.setVisible(false);
            submitBtn.setText("Crear");
            current = OP.CREAR;
        }

        actualizaVistaPrevia(p);
        actualizaCrearFormulario(p);
    }



    /**
     * Inicializa la vista, añade funcionalidades a los elementos de la vista
     */
    private void initializeView() {
        current = OP.CREAR;
        prod = new Producto();

        //Añade funcionalidad al hacer click en una fila
        this.tablaResultados.setRowFactory(tr -> {
            TableRow<Producto> row = new TableRow<>();
            row.setOnMouseClicked(event-> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                    Producto clicked = row.getItem();
                    cambiaProductoActual(clicked);
                }
            });
            return row;
        });

        //Adaptador entre entidades y columnas.
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDetalles.setCellValueFactory(new PropertyValueFactory<>("detalles"));
        colImg.setCellValueFactory(new PropertyValueFactory<>("imagen"));
        colVendedor.setCellValueFactory(new PropertyValueFactory<>("vendedor"));

        colCaducidad.setCellValueFactory(new PropertyValueFactory<>("caducidad"));
        colCaducidad.setCellFactory((column -> new TableCell<Producto, XMLGregorianCalendar>() {
            private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            @Override
            protected void updateItem(XMLGregorianCalendar item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.toGregorianCalendar() == null) {
                    setText(null);
                } else {
                    setText(format.format(item.toGregorianCalendar().getTime()));
                }
            }
        }));


        //Map Formulario -> Vista;
        crearNombre.textProperty().addListener((observable, oldValue, newValue) -> vistaNombre.setText(newValue));
        crearVendedor.textProperty().addListener((observable, oldValue, newValue) -> vistaVendedor.setText(newValue));
        crearDetalles.textProperty().addListener((observable, oldValue, newValue) -> vistaDetalles.setText(newValue));
        crearCantidad.textProperty().addListener((observable, oldValue, newValue) -> {

            if ("".equals(newValue))return;

            try {
                Integer.parseInt(newValue);
                vistaCantidad.setText(newValue);
                crearCantidad.setStyle("-fx-border-color: black");
            }catch(Exception e) {
                crearCantidad.setStyle("-fx-border-color: red");
                crearCantidad.setText(oldValue);
            }
        });
        crearPrecio.textProperty().addListener((observable, oldValue, newValue) -> {

            if ("".equals(newValue))return;

            try {
                Double.parseDouble(newValue);
                crearPrecio.setStyle("-fx-border-color: black");
                vistaPrecio.setText(newValue);
            } catch(Exception e) {
                vistaPrecio.setText(oldValue);
                crearPrecio.setText(oldValue);
                crearPrecio.setStyle("-fx-border-color: red");
            }
        });
        crearImagen.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            try {
                vistaImagen.setSmooth(true);
                vistaImagen.setImage(new Image(newValue));
            } catch (Exception e) {
                notification.setText(e.getMessage());
            }
        });
        crearFecha.valueProperty().addListener((observable, oldValue, newValue) -> vistaFecha.setText(newValue.atStartOfDay().toLocalDate().toString()));
        formCaducidadPicker.setValue(LocalDate.now());
        cambiaProductoActual(this.prod);
    }

    public static XMLGregorianCalendar extractDate(DatePicker datePicker) throws DatatypeConfigurationException {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(Date.from(datePicker.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
    }
}
