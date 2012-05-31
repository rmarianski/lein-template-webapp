(ns {{name}}.routes
  (:use [compojure.core :only (GET defroutes)])
  (:require [{{name}}.views :as views]
            [compojure.route :as route]
            [compojure.handler :as handler]))

(defroutes main-routes
  (GET "/" request views/index)
  (route/resources "/")
  (route/not-found views/not-found))

(def app
  (handler/site main-routes))
