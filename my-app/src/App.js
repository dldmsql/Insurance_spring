import React, { Component } from "react";
import axios from "axios";

class App extends Component {
    state = {
        loading: false,
        ItemList: []  // 비어있는 배열
    };
    // APP.js 컴포넌트의 최종 보여지는 render값 정의

    render() {
        return (
            <div>
                <Listpage />
            </div>
        );
    }
}
export default App;