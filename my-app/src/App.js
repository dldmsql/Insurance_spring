import React from 'react';
import AppRouter from "./components/route/RouterComponent";
import NavBar from "./components/route/NavBar";
import {Container} from "@material-ui/core";

function App() {
    return (
        <div className="App">
            <NavBar/>
            <Container>
                <AppRouter/>
            </Container>
        </div>
    );
}

export default App;