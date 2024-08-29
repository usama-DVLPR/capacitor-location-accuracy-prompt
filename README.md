# capacitor-location-accuracy-prompt

A Capacitor plugin designed to manage and prompt users for location accuracy settings on Android and iOS devices. This plugin helps ensure that your app requests and receives accurate location data, improving the user experience by guiding them to enable the necessary settings.

## Install

```bash
npm install capacitor-location-accuracy-prompt
npx cap sync
```


## Permissions
To use this plugin, make sure to add the following permissions to your Android AndroidManifest.xml file:

```bash
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />

```

## API
<docgen-index>

* [`checkLocationAccuracy()`](#checklocationaccuracy)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### checkLocationAccuracy()

```typescript
checkLocationAccuracy() => Promise<{ status: string; }>
```

**Returns:** <code>Promise&lt;{ status: string; }&gt;</code>

--------------------

</docgen-api>
