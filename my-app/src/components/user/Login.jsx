import React from "react";
import ApiService from "../../ApiMainService";

class Login extends React.Component{
    constructor(props) {
        super(props);

        this.state = {
            id : "",
            pw: "",
            message: null
        };
    }
    handleID =(e) => {
        this.setState({
            id: e.target.value
        });
    };
    handlePW = (e) => {
        this.setState({
            pw: e.target.value
        });
    };

    handleSubmit = (e) => {
        e.preventDefault();

        let login = {
            id: this.state.id,
            pw: this.state.pw
        }
        ApiService.login(login)
            .then(res => {
                this.setState({
                    message: login.id + ' 로그인 성공'
                })
                console.log(this.state.message);
                this.props.history.push('/login');
            })
            .catch(err => {
                console.log(this.state.id);
                console.log('handleSubmit() 에러', err);
            });
    }

    render() {
        return(

                <div>
                    <form onSubmit={this.handleSubmit}>
                        <div>
                            <label>ID</label>
                            <input placeholder="아이디 입력하세요." value={this.state.id} onChange={this.handleID}/>
                        </div>
                        <div>
                            <label>PW</label>
                            <input placeholder="비밀번호 입력하세요." type="password" value={this.state.pw} onChange={this.handlePW}/>
                        </div>
                        <div>
                            <button type={"submit"}>로그인</button>
                        </div>
                    </form>
                </div>

        );
    }
}
export default Login;