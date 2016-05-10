(ns code-examples.core
  (:require [code-examples.identity-check :as idc]
            [code-examples.lead-verify :as lv]))

(defn -main
  [& [api]]
  (if-let [checks (case api
                  "lead_verify" (lv/run-request)
                  "identity_check" (idc/run-request)
                  nil)]
    (doseq [[k v] checks] (prn v))
    (println "Undefined API")))
