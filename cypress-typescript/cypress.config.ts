import { defineConfig } from 'cypress'

module.exports = defineConfig({
  chromeWebSecurity: false,
  experimentalModifyObstructiveThirdPartyCode: true,
  modifyObstructiveCode: false ,
  blockHosts: [
    'securepubads.g.doubleclick.net',
    'btloader.com',
    '*.adnxs.com',
    'ads.pubmatic.com',
    'image6.pubmatic.com',
    'www.awxcdn.com',
    'token.rubiconproject.com',
    '*.safeframe.googlesyndication.com',
    'htlb.casalemedia.com',
    'fastlane.rubiconproject.com',
    'tlx.3lift.com',
    'hbopenbid.pubmatic.com'
  ],
  projectId: 'v7pjor',
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
      
    },
  },
});
