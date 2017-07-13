(ns playground.core)

;; HTML generator macro
;; 1 - Simple use case

;; (html (h1 "Hello World"))

;;=> "<html><h1>Hello World</h1></html>"

(defmacro html [form] 
    (let [tag `(first '~form) 
	  attributes `(clojure.string/join " " (map (fn [[~'k ~'v]] (str (name ~'k) "='" ~'v "'")) (second '~form))) 
	  content `(rest (rest '~form))]

	`(str "<" ~tag " " ~attributes ">" (apply str ~content) "</" ~tag ">")))
