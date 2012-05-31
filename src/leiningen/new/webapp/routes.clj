(ns {{name}}.routes
  (:use
     [compojure.core :only (GET defroutes)]
     [ring.middleware.keyword-params :only (wrap-keyword-params)]
     [ring.middleware.multipart-params :only (wrap-multipart-params)]
     [ring.middleware.nested-params :only (wrap-nested-params)]
     [ring.middleware.params :only (wrap-params)]
     [servlet-session-store.core :only (wrap-servlet-session)])
  (:require [{{name}}.views :as views]
            [compojure.route :as route]
            [compojure.handler :as handler]))

(defroutes main-routes
  (GET "/" request views/index)
  (route/resources "/")
  (route/not-found views/not-found))

(def app
  (-> main-routes
      wrap-servlet-session
      wrap-keyword-params
      wrap-multipart-params
      wrap-nested-params
      wrap-params))
