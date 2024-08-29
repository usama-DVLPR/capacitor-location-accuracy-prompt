export interface LocationAccuracyPluginPlugin {
  // echo(options: { value: string }): Promise<{ value: string }>;
  checkLocationAccuracy(): Promise<{ status: string }>;

}
