(ns {{name}}.core
  (:require [clojure.browser.repl :as repl]
            [clojure.browser.dom :as dom]))

; (repl/connect "http://localhost:9000/repl")

(defn ^:export say-hello []
  (js/setTimeout
   #(dom/append
     (.-body js/document)
     (dom/element [:p "Hi from clojurescript!"]))
   1000))
