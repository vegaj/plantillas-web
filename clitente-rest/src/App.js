import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch, Link } from "react-router-dom";
import { Redirect } from 'react-router';
import Axios from 'axios';
import AppBar from '@material-ui/core/AppBar';
import { Typography, Grid, Button, Toolbar, withStyles } from '@material-ui/core';
import TablaEntidad from './components/TablaEntidad';
import VistaEntidad from './components/VistaEntidad';
import { API, GOOGLE_CLIENT_ID } from './cte';

const styles = theme => ({
  root: {
    width: '100%',
  },
  grow: {
    flexGrow: 1,
  },
  menuButton: {
    marginLeft: -12,
    marginRight: 20,
  },
  title: {
    display: 'none',
    [theme.breakpoints.up('sm')]: {
      display: 'block',
    },
    color: 'white',
    marginRight: theme.spacing.unit * 4
  },
  inputRoot: {
    color: 'inherit',
    width: '100%',
  },
  inputInput: {
    paddingTop: theme.spacing.unit,
    paddingRight: theme.spacing.unit,
    paddingBottom: theme.spacing.unit,
    paddingLeft: theme.spacing.unit * 10,
    transition: theme.transitions.create('width'),
    width: '100%',
    [theme.breakpoints.up('sm')]: {
      width: 120,
      '&:focus': {
        width: 200,
      },
    },
  },
});



class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      list: [],
      user: { email: "orsetto@mail.com"},
    }
  }

  handleFindAll = async () => {
    try {
      let resp = await Axios.get(`${API}/productos`);
      resp = resp.data;
      this.setState({list: resp});
    } catch (err) {
      alert(err)
    }
  }

  async componentDidMount() {
    try {
      let resp = await Axios.get(`${API}/productos`);
      resp = resp.data;
      console.log(resp);
      this.setState({ list: resp });
    } catch (err) {
      alert(err)
    }
  }

  render() {

    const { classes } = this.props;
    return (
      <div>
        <Router >
          <div>
            <AppBar position='sticky'>
              <Toolbar>
                <Typography variant='h4' component={Link} to="/" className={classes.title}>App </Typography>
                <Button variant='contained' color='secondary' component={Link} to={'/entity/'}>Crear</Button>
                <Route render={({history}) => (<Button variant='contained' color='secondary' onClick={()=>{this.handleFindAll(); history.push("/")}}>Refrescar Todos</Button>)} />
              </Toolbar>
            </AppBar>
            <Route exact path="/" render={(props) => <TablaEntidad title='Resultados' list={this.state.list} {...props} />} />
            <Switch>
              <Route exact path="/entity/" render={(props) => <VistaEntidad user={this.state.user} id={undefined} {...props} />} />
              <Route path="/entity/:id" render={(props) => <VistaEntidad user={this.state.user} id={props.match.params.id}  {...props} />} />
            </Switch>

          </div>
        </Router>
      </div>
    );
  }
}

export default withStyles(styles)(App);
