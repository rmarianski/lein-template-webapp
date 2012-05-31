(ns {{name}}.core
  (:use [ring.adapter.jetty :only (run-jetty)]
        [{{name}}.routes :only (app)])
  (:import [org.eclipse.jetty.server Server]))

(def server (atom nil))

(defn stop-server []
  (when-let [s @server]
    (.stop ^Server s)))

(defn run-server [& [port]]
  (stop-server)
  (reset!
   server
   (run-jetty #'app {:port (or port 8080) :join? false})))

(defn -main [& args] (run-jetty))
