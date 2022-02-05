import React, {Component} from "react";
import {Button, Table, TableBody, TableCell, TableHead, TableRow, Typography} from "@material-ui/core";
import AddIcon from '@material-ui/icons/Add';
import DeleteIcon from '@material-ui/icons/Delete';
import ApiSalesService from "../../ApiSalesService";

class UserListComponent extends Component{
    constructor(props) {
        super(props);

        this.state = {
            users: [],
            message: null
        }
    }
    componentDidMount() {
        this.reloadUserList();
    }
    reloadUserList = () => {
        ApiSalesService.fetchUsers()
            .then( res => {
                this.setState({
                    users: res.data
                })
            })
            .catch(err => {
                console.log('reloadUserList() error!', err);
            })
    }
    deleteUser = (userID) => {
        ApiSalesService.deleteUser(userID)
            .then( res => {
                this.setState({
                        message: 'User Deleted Successfully.'
                });
                this.setState({
                    users: this.state.users.filter(user =>
                user.id !== userID)
            });
            })
            .catch( err => {
                console.log('deleteUser() Error!', err);
            })
    }
    editUser = (ID) => {
        window.localStorage.setItem("ID", ID);
        this.props.history.push('/edit-user');
    }
    addUser = () => {
        window.localStorage.removeItem("ID");
        this.props.history.push("/add-user");
    }

    render() {
        return(
            <div>
                <Typography variant="h4" style={style}>User List</Typography>
                <Button variant="contained" color="primary" onClick={this.addUser}> Add User </Button>
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell>ID</TableCell>
                            <TableCell>First Name</TableCell>
                            <TableCell align="right">Last Name</TableCell>
                            <TableCell align="right">Job</TableCell>
                            <TableCell align="right">Edit</TableCell>
                            <TableCell align="right">Delete</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                    {this.state.users.map ( user =>
                    <TableRow key={user.id}>
                        <TableCell>{user.id}</TableCell>
                        <TableCell>{user.firstName}</TableCell>
                        <TableCell align="right">{user.lastName}</TableCell>
                        <TableCell align="right">{user.job}</TableCell>
                        <TableCell align="right" onClick={() => this.editUser(user.id)}>
                            <AddIcon/>
                        </TableCell>
                        <TableCell align="right" onClick={() => this.deleteUser(user.id)}>
                            <DeleteIcon/>
                        </TableCell>
                    </TableRow>
                    )}
                    </TableBody>
                </Table>
            </div>
        );
    }
}
const style = {
    display: 'flex',
    justifyContent : 'center'
}
export default UserListComponent;