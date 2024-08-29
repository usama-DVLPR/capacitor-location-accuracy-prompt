export interface LocationAccuracyPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
