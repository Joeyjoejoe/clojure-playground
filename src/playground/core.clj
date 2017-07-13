(ns playground.core)

;; HTML generator macro
;; 1 - Simple use case

;; (html (h1 {:class "test" :id "test"} "Hello World"))

;;=> "<html><h1 class="test" id="test">Hello World</h1></html>"

(defmacro html-tag [form] 
    (let [tag# `(first '~form) 
	  attributes# `(clojure.string/join " " (map (fn [[~'k ~'v]] (str (name ~'k) "='" ~'v "'")) (second '~form))) 
	  content# `(rest (rest '~form))]

	`(str "<" ~tag# " " ~attributes# ">" (apply str ~content#) "</" ~tag# ">")))

(defmacro html [& forms]
  `(clojure.string/join ~(map #(html-tag %) ~@forms))
)

(defn banane [] "banane")
