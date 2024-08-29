import { WebPlugin } from '@capacitor/core';

import type { LocationAccuracyPluginPlugin } from './definitions';

export class LocationAccuracyPluginWeb
  extends WebPlugin
  implements LocationAccuracyPluginPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
