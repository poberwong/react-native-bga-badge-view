
# react-native-bga-badge-view

## Getting started

`$ npm install react-native-bga-badge-view --save`

### Mostly automatic installation

`$ react-native link react-native-bga-badge-view`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-bga-badge-view` and add `RNBgaBadgeView.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNBgaBadgeView.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNBgaBadgeViewPackage;` to the imports at the top of the file
  - Add `new RNBgaBadgeViewPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-bga-badge-view'
  	project(':react-native-bga-badge-view').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-bga-badge-view/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-bga-badge-view')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNBgaBadgeView.sln` in `node_modules/react-native-bga-badge-view/windows/RNBgaBadgeView.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Cl.Json.RNBgaBadgeView;` to the usings at the top of the file
  - Add `new RNBgaBadgeViewPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNBgaBadgeView from 'react-native-bga-badge-view';

// TODO: What do with the module?
RNBgaBadgeView;
```
  