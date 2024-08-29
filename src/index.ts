import { registerPlugin } from '@capacitor/core';

import type { LocationAccuracyPluginPlugin } from './definitions';

const LocationAccuracyPlugin = registerPlugin<LocationAccuracyPluginPlugin>(
  'LocationAccuracyPlugin',
  {
    web: () => import('./web').then(m => new m.LocationAccuracyPluginWeb()),
  },
);

export * from './definitions';
export { LocationAccuracyPlugin };
