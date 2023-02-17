/* global app, Router */

(function (app, Router) {
  'use strict'

  const router = new Router();

  ['all', 'active', 'completed'].forEach((visibility) => {
    router.on(visibility, () => {
      app.visibility = visibility
    })
  })

  router.configure({
    notfound() {
      window.location.hash = ''
      app.visibility = 'all'
    },
  })

  router.init()
})(app, Router)
