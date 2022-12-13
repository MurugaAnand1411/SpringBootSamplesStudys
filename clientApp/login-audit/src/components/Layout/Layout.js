import React from 'react'
import MainNavigation from "./MainNav";
import Footer from '../Layout/Footer/Footer'
import classes from './layout.css'
function Layout(props) {
    return (
        <div >
            <MainNavigation  />
            <main classes={classes.main}>{props.children}</main>
            <Footer  />
        </div>
    );
}


export default Layout;