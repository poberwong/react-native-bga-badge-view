/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import BGABadgeView from 'react-native-bga-badge-view'
import {
  AppRegistry,
  StyleSheet,
  ToastAndroid,
  Text,
  View
} from 'react-native';

export default class Example extends Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native
        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.android.js
        </Text>
        <Text style={styles.instructions}>
          Double tap R on your keyboard to reload,{'\n'}
          Shake or press menu button for dev menu
        </Text>
        <BGABadgeView textBadge="999999" style={styles.badge} />
      </View>
    );
  }

  onDismiss = () => {
    ToastAndroid.show('消失 ', ToastAndroid.SHORT)
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  badge: {
    width: 60,
    height: 60
  }
});

AppRegistry.registerComponent('Example', () => Example);
