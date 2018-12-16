
package ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ComparResponse_QNAME = new QName("http://ws/", "comparResponse");
    private final static QName _CaducadosDesde_QNAME = new QName("http://ws/", "caducadosDesde");
    private final static QName _Edit_QNAME = new QName("http://ws/", "edit");
    private final static QName _FindRange_QNAME = new QName("http://ws/", "findRange");
    private final static QName _Count_QNAME = new QName("http://ws/", "count");
    private final static QName _CountResponse_QNAME = new QName("http://ws/", "countResponse");
    private final static QName _FindResponse_QNAME = new QName("http://ws/", "findResponse");
    private final static QName _Producto_QNAME = new QName("http://ws/", "producto");
    private final static QName _FindAll_QNAME = new QName("http://ws/", "findAll");
    private final static QName _Remove_QNAME = new QName("http://ws/", "remove");
    private final static QName _CaducadosDesdeResponse_QNAME = new QName("http://ws/", "caducadosDesdeResponse");
    private final static QName _FindRangeResponse_QNAME = new QName("http://ws/", "findRangeResponse");
    private final static QName _ReponerResponse_QNAME = new QName("http://ws/", "reponerResponse");
    private final static QName _Find_QNAME = new QName("http://ws/", "find");
    private final static QName _Reponer_QNAME = new QName("http://ws/", "reponer");
    private final static QName _Create_QNAME = new QName("http://ws/", "create");
    private final static QName _FindAllResponse_QNAME = new QName("http://ws/", "findAllResponse");
    private final static QName _Compar_QNAME = new QName("http://ws/", "compar");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ComparResponse }
     * 
     */
    public ComparResponse createComparResponse() {
        return new ComparResponse();
    }

    /**
     * Create an instance of {@link CaducadosDesde }
     * 
     */
    public CaducadosDesde createCaducadosDesde() {
        return new CaducadosDesde();
    }

    /**
     * Create an instance of {@link Edit }
     * 
     */
    public Edit createEdit() {
        return new Edit();
    }

    /**
     * Create an instance of {@link FindRange }
     * 
     */
    public FindRange createFindRange() {
        return new FindRange();
    }

    /**
     * Create an instance of {@link Count }
     * 
     */
    public Count createCount() {
        return new Count();
    }

    /**
     * Create an instance of {@link CountResponse }
     * 
     */
    public CountResponse createCountResponse() {
        return new CountResponse();
    }

    /**
     * Create an instance of {@link FindResponse }
     * 
     */
    public FindResponse createFindResponse() {
        return new FindResponse();
    }

    /**
     * Create an instance of {@link Producto }
     * 
     */
    public Producto createProducto() {
        return new Producto();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link Remove }
     * 
     */
    public Remove createRemove() {
        return new Remove();
    }

    /**
     * Create an instance of {@link CaducadosDesdeResponse }
     * 
     */
    public CaducadosDesdeResponse createCaducadosDesdeResponse() {
        return new CaducadosDesdeResponse();
    }

    /**
     * Create an instance of {@link FindRangeResponse }
     * 
     */
    public FindRangeResponse createFindRangeResponse() {
        return new FindRangeResponse();
    }

    /**
     * Create an instance of {@link ReponerResponse }
     * 
     */
    public ReponerResponse createReponerResponse() {
        return new ReponerResponse();
    }

    /**
     * Create an instance of {@link Find }
     * 
     */
    public Find createFind() {
        return new Find();
    }

    /**
     * Create an instance of {@link Reponer }
     * 
     */
    public Reponer createReponer() {
        return new Reponer();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link Compar }
     * 
     */
    public Compar createCompar() {
        return new Compar();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComparResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "comparResponse")
    public JAXBElement<ComparResponse> createComparResponse(ComparResponse value) {
        return new JAXBElement<ComparResponse>(_ComparResponse_QNAME, ComparResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaducadosDesde }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "caducadosDesde")
    public JAXBElement<CaducadosDesde> createCaducadosDesde(CaducadosDesde value) {
        return new JAXBElement<CaducadosDesde>(_CaducadosDesde_QNAME, CaducadosDesde.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Edit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "edit")
    public JAXBElement<Edit> createEdit(Edit value) {
        return new JAXBElement<Edit>(_Edit_QNAME, Edit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRange }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findRange")
    public JAXBElement<FindRange> createFindRange(FindRange value) {
        return new JAXBElement<FindRange>(_FindRange_QNAME, FindRange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Count }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "count")
    public JAXBElement<Count> createCount(Count value) {
        return new JAXBElement<Count>(_Count_QNAME, Count.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "countResponse")
    public JAXBElement<CountResponse> createCountResponse(CountResponse value) {
        return new JAXBElement<CountResponse>(_CountResponse_QNAME, CountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findResponse")
    public JAXBElement<FindResponse> createFindResponse(FindResponse value) {
        return new JAXBElement<FindResponse>(_FindResponse_QNAME, FindResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Producto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "producto")
    public JAXBElement<Producto> createProducto(Producto value) {
        return new JAXBElement<Producto>(_Producto_QNAME, Producto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Remove }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "remove")
    public JAXBElement<Remove> createRemove(Remove value) {
        return new JAXBElement<Remove>(_Remove_QNAME, Remove.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaducadosDesdeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "caducadosDesdeResponse")
    public JAXBElement<CaducadosDesdeResponse> createCaducadosDesdeResponse(CaducadosDesdeResponse value) {
        return new JAXBElement<CaducadosDesdeResponse>(_CaducadosDesdeResponse_QNAME, CaducadosDesdeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRangeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findRangeResponse")
    public JAXBElement<FindRangeResponse> createFindRangeResponse(FindRangeResponse value) {
        return new JAXBElement<FindRangeResponse>(_FindRangeResponse_QNAME, FindRangeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReponerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "reponerResponse")
    public JAXBElement<ReponerResponse> createReponerResponse(ReponerResponse value) {
        return new JAXBElement<ReponerResponse>(_ReponerResponse_QNAME, ReponerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Find }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "find")
    public JAXBElement<Find> createFind(Find value) {
        return new JAXBElement<Find>(_Find_QNAME, Find.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reponer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "reponer")
    public JAXBElement<Reponer> createReponer(Reponer value) {
        return new JAXBElement<Reponer>(_Reponer_QNAME, Reponer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Compar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "compar")
    public JAXBElement<Compar> createCompar(Compar value) {
        return new JAXBElement<Compar>(_Compar_QNAME, Compar.class, null, value);
    }

}
