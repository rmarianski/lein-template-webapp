(ns {{name}}.core
  (:use [domina.xpath :only (xpath)])
  (:require [clojure.browser.repl :as repl]
            [clojure.browser.dom :as dom]
            [domina :as d]))

; (repl/connect "http://localhost:9000/repl")

(defn ^:export say-hello []
  (js/setTimeout
   #(d/append!
     (xpath "//body")
     (dom/element [:p "Hi from clojurescript!"]))
   1000))
