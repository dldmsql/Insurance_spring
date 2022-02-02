import React from "react";

import AppBar from '@material-ui/core/AppBar';
import {Button, IconButton, Toolbar, Typography} from "@material-ui/core";


function MenuIcon() {
    return null;
}

const NavBar = () => {
    return(
        <div>
            <AppBar position="static">
                <Toolbar>
                    <IconButton edge="start" color="inherit" aria-label="Menu">
                        <MenuIcon/>
                    </IconButton>
                    <Typography variant="h6" style={style}>
                        React User Application
                    </Typography>
                    <Button color="inherit">Login</Button>
                </Toolbar>
            </AppBar>
        </div>
    );
}
const style = {
    flexGrow: 1
}
export default NavBar;