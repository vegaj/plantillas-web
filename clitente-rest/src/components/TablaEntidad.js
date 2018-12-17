import React, { Component } from 'react';
import { withStyles } from '@material-ui/core/styles';
import {Link} from 'react-router-dom';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import {Button, Typography} from '@material-ui/core'

const styles = theme => ({
    root: {
      width: '100%',
      marginTop: theme.spacing.unit * 3,
      overflowX: 'auto',
    },
    table: {
      minWidth: 700,
    },
    img: {
        minWidth: 64,
        maxWidth: 96,
        height: 'auto' 
    }
  });

class TablaEntidad extends Component {

    render() {

        const { classes, list, title } = this.props;
        return (<Paper className={classes.root}>
            <Typography variant='h2' component='h2'>{title}</Typography>
            <Table className={classes.table}>
                <TableHead>
                    <TableRow>
                        <TableCell numeric>ID</TableCell>
                        <TableCell >Imagen</TableCell>
                        <TableCell >Nombre</TableCell>
                        <TableCell numeric>Precio</TableCell>
                        <TableCell numeric>Disponible</TableCell>
                        <TableCell numeric>Vendido por</TableCell>
                        <TableCell numeric>Caducidad</TableCell>
                        <TableCell>Opciones</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {list.map(row => {
                        return (
                            <TableRow key={row.id}>
                                <TableCell numeric>{row.id}</TableCell>
                                <TableCell><img className={classes.img} src={row.imagen} alt={row.nombre}/></TableCell>
                                <TableCell component="th" scope="row">
                                    {row.nombre}
                                </TableCell>
                                <TableCell numeric>{row.precio}</TableCell>
                                <TableCell numeric>{row.cantidad}</TableCell>
                                <TableCell numeric>{row.vendedor}</TableCell>
                                <TableCell numeric>{row.caducidad.slice(0,10)}</TableCell>
                                <TableCell>
                                    <Button component={Link} to={`/entity/${row.id}`}>Ver</Button>
                                </TableCell>
                            </TableRow>
                        );
                    })}
                </TableBody>
            </Table>
        </Paper>)
    }
}

export default withStyles(styles)(TablaEntidad);