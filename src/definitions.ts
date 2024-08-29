export interface LocationAccuracyPluginPlugin {
  checkLocationAccuracy(): Promise<{ status: string }>; // Android-only

}
