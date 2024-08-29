import { WebPlugin } from '@capacitor/core';

import type { LocationAccuracyPluginPlugin } from './definitions';

export class LocationAccuracyPluginWeb
  extends WebPlugin
  implements LocationAccuracyPluginPlugin
{
  // async echo(options: { value: string }): Promise<{ value: string }> {
  //   console.log('ECHO', options);
  //   return options;
  // }

  async checkLocationAccuracy(): Promise<{ status: string }> {
    // Web implementation of location accuracy check
    console.warn('checkLocationAccuracy is not available on the web.');
    return { status: 'unsupported' }; // Return a default response for the web
  }
}
