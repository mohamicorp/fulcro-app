(ns app.client
  (:require
   [com.fulcrologic.fulcro.application :as app]
   [com.fulcrologic.fulcro.components :as comp :refer [defsc]]
   [com.fulcrologic.fulcro-i18n.i18n :refer [tr]]
   [com.fulcrologic.fulcro.dom :as dom]
   [fulcro-atlaskit.fuegokit :as fuegokit]
   [fulcro-atlaskit.button :as button]))

(defonce app (app/fulcro-app))

(defsc Root [this _]
  (dom/div
   (dom/h1 (tr " Get started"))
   (dom/p
    (tr
     "The Numbered headings app has been installed successfully. Get started right away and go to the page where you want to use Numbered Headings."))
   (dom/h2 (tr "Documentation"))
   (dom/p (tr "In our documentation we explain exactly how you can get the most out of the app."))
   (dom/div
    :.button
    (button/ui-button
     {:href "https://apps.appf.re/nh/doc/cloud"
      :target "_blank"}
     (tr "Documentation")))
   (fuegokit/ui-box)
   ))

(defn ^:export init
  "Shadow-cljs sets this up to be our entry-point function. See shadow-cljs.edn `:init-fn` in the modules of the main build."
  []
  (app/mount! app Root "app")
  (js/console.log "Loaded"))

(defn ^:export refresh
  "During development, shadow-cljs will call this on every hot reload of source. See shadow-cljs.edn"
  []
  ;; re-mounting will cause forced UI refresh, update internals, etc.
  (app/mount! app Root "app")
  ;; As of Fulcro 3.3.0, this addition will help with stale queries when using dynamic routing:
  (comp/refresh-dynamic-queries! app)
  (js/console.log "Hot reload"))