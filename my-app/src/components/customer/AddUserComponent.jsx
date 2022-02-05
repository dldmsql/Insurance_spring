import React, {Component} from "react";
import ApiService from "../../ApiSalesService";
import {Button, TextField, Typography} from "@material-ui/core";
import Select from 'react-select';

const options = [
    { value: "student", label: "학생" },
    { value: "officer", label: "사무직" },
    { value: "driver", label: "운전자" }
];

class AddUserComponent extends Component{
    constructor(props) {
        super(props);

        this.state =
            {
                firstName:'',
                lastName:'',
                job:'',
                message: null
            }
    }

    onChange = (e ) => {
        this.setState({
            [e.target.name] : e.target.value
        })
    }
    handleJob = (e) => {
        this.setState({
            job: e.target.value
        });
        console.log(this.state.job);
    };

    saveUser = (e) => {
        e.preventDefault();

        let user = {
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            job: this.state.job
        }
        ApiService.addUser(user)
            .then(res => {
                this.setState({
                    message: user.lastName + '님이 성공적으로 등록되었습ㄴ디ㅏ.'
                })
                console.log(this.state.message);
                this.props.history.push('/customer');
            })
            .catch( err => {
                console.log('saveUser() 에러', err);
            });
    }

    render() {
        return (
            <div>
                <Typography variant="h4" style={style}>Add User</Typography>
                <form style={formContainer} onSubmit={this.saveUser}>

                        <TextField placeholder="please input your firstName" name="firstName" value={this.state.firstName}
                                   fullWidth margin="normal" onChange={this.onChange}/>

                        <TextField placeholder="please input your lastName" name="lastName" value={this.state.lastName}
                               fullWidth margin="normal" onChange={this.onChange}/>

                    <Select options={options} onChange={this.handleJob} defaultValue={options[1]} />

                    <div>
                        <Button variant="contained" color="primary" type={"submit"}>Save</Button>
                    </div>
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