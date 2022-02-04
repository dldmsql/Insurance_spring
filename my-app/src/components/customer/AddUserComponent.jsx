import React, {Component} from "react";
import ApiService from "../../ApiMainService";
import {Button, TextField, Typography} from "@material-ui/core";

class AddUserComponent extends Component{
    constructor(props) {
        super(props);

        this.state =
            {
                password: '',
                firstName: '',
                lastName:'',
                employeeDepart:'',
                message: null
            }
    }

    onChange = (e ) => {
        this.setState({
            [e.target.name] : e.target.value
        })
    }

    saveUser = (e) => {
        e.preventDefault();

        let user = {
            password: this.state.password,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            employeeDepart: this.state.employeeDepart
        }

        ApiService.addUser(user)
            .then(res => {
                this.setState({
                    message: user.lastName + '님이 성공적으로 등록되었습ㄴ디ㅏ.'
                })
                console.log(this.state.message);
                this.props.history.push('/users');
            })
            .catch( err => {
                console.log('saveUser() 에러', err);
            });
    }

    render() {
        return (
            <div>
                <Typography variant="h4" style={style}>Add User</Typography>
                <form style={formContainer}>

                        <TextField type="password" placeholder="please input your password" name="password"
                                  fullWidth margin="normal" value={this.state.password}  onChange={this.onChange}/>


                        <TextField placeholder="please input your firstName" name="firstName" value={this.state.firstName}
                                   fullWidth margin="normal" onChange={this.onChange}/>


                        <TextField placeholder="please input your lastName" name="lastName" value={this.state.lastName}
                               fullWidth margin="normal" onChange={this.onChange}/>

                        <TextField placeholder="please input your employeeDepart" name="employeeDepart" value={this.state.employeeDepart}
                               fullWidth margin="normal" onChange={this.onChange}/>

                    <Button variant="contained" color="primary" onChange={this.saveUser}>Save</Button>
                </form>
            </div>
        );
    }
}

const formContainer = {
    display: 'flex',
    flexFlow: 'row wrap'
}
const style = {
    display: 'flex',
    justifyContent : 'center'
}
export default AddUserComponent;