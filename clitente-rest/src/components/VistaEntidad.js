import React, { Component } from 'react';
import { withStyles, Button, Typography, Paper } from "@material-ui/core";
import { DateFormatInput } from "material-ui-next-pickers";
import { Link } from 'react-router-dom';
import { Redirect } from 'react-router';
import Axios from 'axios';
import { API } from '../cte';
import TextField from '@material-ui/core/TextField';
import { Grid } from '@material-ui/core';
import Producto, { Validate } from '../models/Producto';

const styles = theme => ({
    container: {
        display: 'flex',
        flexWrap: 'wrap',
        padding: theme.spacing.unit * 3,
    },
    textField: {
        marginLeft: theme.spacing.unit,
        marginRight: theme.spacing.unit,
        width: '80%',
    },
    img: {
        maxWidth: '256px',
        minWidth: '65px',
        height: 'auto',
        border: '1px dotted black',
        borderRadius: '5%',
        margin: theme.spacing.unit * 3,
    },
    imgTextField: {
        marginLeft: theme.spacing.unit,
        marginRight: theme.spacing.unit,
        width: '50%',
    },
    dense: {
        marginTop: 19,
    },
    menu: {
        width: 200,
    },
});


class VistaEntidad extends Component {

    constructor(props) {
        super(props)
        this.state = {
            sub: {
                nombre: "Dummy",
                vendedor: "System",
            },
            redirect: false,
            ok: true,
            isOwner: false,
            date: new Date()
        }
    }

    async componentDidMount() {

        if (!this.props.id || isNaN(Number.parseInt(this.props.id))) {
            console.log("Creando nuevo producto");
            this.setState({
                sub: new Producto({ id: 0, vendedor: this.props.user.email }),
                isOwner: true,
            })

            console.log(`Nueva creacion: ${JSON.stringify(this.state)}`);
            return;
        }

        try {
            let resp = await Axios.get(`${API}/productos/${this.props.id}`)
            resp = resp.data;
            this.setState({ sub: new Producto(resp), isOwner: resp.vendedor === this.props.user.email, });
        } catch (err) {
            alert(err);
            alert('Error de conexión. Intente más tarde');
            this.setState({ ok: false });
        }

    }

    handleChange = name => event => {
        const val = event.currentTarget.value;
        const { sub } = this.state;
        sub[name] = val;
        this.setState({ sub });
        console.log(sub);
    }

    handleDateChange = (date) => {
        const { sub } = this.state;
        sub['caducidad'] = date;
        this.setState({ sub });
    }

    handleBorrar = async (event) => {
        try {
            const { sub } = this.state;
            await Axios.delete(`${API}/productos/${sub.id}`);
            this.setState({redirect: true})
        } catch(err) {
            alert('No se pudo eliminar');
        }
    }

    handleClick = async (event) => {

        const { sub } = this.state;

        if (!Validate(sub)) {
            alert('Hay campos invalidos');
            return;
        }

        console.log(sub)
        if (sub.id === undefined || sub.id <= 0) {
            //Crear
            await this.crear(sub);
        } else {
            //Editar
            await this.editar(sub);
        }
        this.setState({redirect: true})
    }

    crear = async (p) => {
        try {
            await Axios.post(`${API}/productos`, p);
            this.setState({ redirect: true })
        } catch (err) {
            console.log(err)
            alert('No se pudo crear')
        }
    }

    editar = async (p) => {
        try {
            await Axios.put(`${API}/productos/${p.id}`, p);
            this.setState({ redirect: true })
        } catch (err) {
            console.log(err)
            alert('No se pudo editar');
        }
    }

    render() {
        const { classes } = this.props;
        const { redirect, sub, isOwner } = this.state;
        return (
            <Paper className={classes.container}>
                {redirect && <Redirect to="/" />}
                <Grid
                    container
                    justify='center'
                    direction='column'
                    alignItems='center'
                >
                    <Typography variant='h2' component='h2'>Vista de Producto</Typography>
                    {isOwner && <Button variant='contained' color='secondary' disabled={sub.id === 0} onClick={this.handleBorrar}>Borrar</Button>}
                    <hr></hr>
                    <TextField
                        className={classes.textField}
                        label="nombre"
                        type="text"
                        value={sub.nombre}
                        onChange={this.handleChange('nombre')}
                    />
                    <TextField
                        className={classes.textField}
                        label="vendedor"
                        type="text"
                        value={sub.vendedor}
                        onChange={this.handleChange('vendedor')}
                        disabled={true}
                    />

                    <TextField
                        className={classes.textField}
                        label="precio"
                        type="number"
                        value={sub.precio}
                        onChange={this.handleChange('precio')}

                    />

                    <TextField
                        className={classes.textField}
                        label="cantidad"
                        type="number"
                        value={sub.cantidad}
                        onChange={this.handleChange('cantidad')}

                    />

                    <TextField
                        id="standard-multiline-flexible"
                        label="Detalles"
                        multiline
                        rowsMax="4"
                        value={sub.detalles}
                        onChange={this.handleChange('detalles')}
                        className={classes.textField}
                        margin="normal"
                    />
                    <DateFormatInput
                        name='date-input'
                        value={sub.caducidad || new Date()}
                        label='Fecha de caducidad'
                        onChange={this.handleDateChange} />
                    <Grid
                        container
                        justify='center'
                        direction='row'
                        alignItems='center'>

                        <TextField
                            className={classes.imgTextField}
                            label="imagen"
                            type="text"
                            value={sub.imagen}
                            onChange={this.handleChange('imagen')}
                        />
                        <img src={sub.imagen} alt='vista previa' className={classes.img} style={{ maxWidth: 256, height: 'auto' }} />
                    </Grid>
                    {isOwner && <Button variant='contained' color='primary' onClick={this.handleClick}>Guardar</Button>}
                </Grid>
            </Paper>
        )
    }
}


export default withStyles(styles)(VistaEntidad);