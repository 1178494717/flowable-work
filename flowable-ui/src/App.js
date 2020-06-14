import React from 'react';
import {Button} from 'antd';
import './App.css';

export default class App extends React.Component {

    handleClick = () => {
        fetch("/user/list", {
            method: "GET"
        }).then(response => response.json())
            .then(result => {
                console.log(result)
            })
    }

    render() {
        return (
            <div className="App">
                <Button type="primary" onClick={this.handleClick}>Button</Button>
            </div>
        )
    }

}