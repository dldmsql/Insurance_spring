import React from 'react';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import UserListComponent from "../customer/UserListComponent";
import AddUserComponent from "../customer/AddUserComponent";
import EditUserComponent from "../customer/EditUserComponent";
import Login from "../user/Login";

const AppRouter = () => {
    return (
      <div style={style}>
          <BrowserRouter>
              <Switch>
                  <Route path="/login" component={Login}/>
                  <Route exact path="/" component={UserListComponent}/>
                  <Route path="/users" component={UserListComponent}/>
                  <Route path="/add-user" component={AddUserComponent}/>
                  <Route path="/edit-user" component={EditUserComponent}/>
              </Switch>
          </BrowserRouter>
      </div>
    );
}

const style = {
    marginTop:'20px'
}
export default AppRouter;