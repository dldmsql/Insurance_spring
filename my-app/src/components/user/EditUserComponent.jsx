import React, {Component} from "react";
import ApiService from "../../ApiService";
import {Button, TextField, Typography} from "@material-ui/core";

class EditUserComponent extends Component{
    constructor(props) {
        super(props);

        this.state =
            {
                firstName: '',
                lastName:'',
                employeeDepart:'',
                message: null
            }
    }

    componentDidMount() {
        this.loadUser();
    }

    loadUser = () => {
        ApiService.fetchUserByID(window.localStorage.getItem("userID"))
            .then(res => {
                let user = res.data;
                this.setState({
                    id: user.id,
                    firstName: user.firstName,
                    lastName: user.lastName,
                    employeeDepart: user.employeeDepart
                })
            })
            .catch(err => {
                console.log('loadUSer() 에러 ', err);
            });
    }

    onChange = (e ) => {
        this.setState({
            [e.target.name] : e.target.value
        })
    }

    saveUser = (e) => {
        e.preventDefault();

        let user = {
            id: this.state.id,
            password: this.state.password,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            employeeDepart: this.state.employeeDepart
        }

        ApiService.editUser(user)
            .then(res => {
                this.setState({
                    message: user.lastName + '님의 정보가 수정되었습니다..'
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
                <Typography variant="h4" style={style}>Edit User</Typography>
                <form>

                    <TextField placeholder="please Edit your firstName" name="firstName" value={this.state.firstName}
                               fullWidth margin="normal" onChange={this.onChange}/>


                    <TextField placeholder="please Edit your lastName" name="lastName" value={this.state.lastName}
                               fullWidth margin="normal" onChange={this.onChange}/>

                    <TextField placeholder="please Edit your employeeDepart" name="employeeDepart" value={this.state.employeeDepart}
                               fullWidth margin="normal" onChange={this.onChange}/>

                    <Button variant="contained" color="primary" onChange={this.saveUser}>Save</Button>
                </form>
            </div>
        );
    }
}

const style = {
    display: 'flex',
    justifyContent : 'center'
}
export default EditUserComponent;