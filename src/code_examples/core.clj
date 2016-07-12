(ns code-examples.core
  (:require [code-examples.identity-check :as idc]
            [code-examples.lead-verify :as lv]
            [code-examples.caller-identification :as cid]
            [clojure.pprint :as pp]))

(defn -main
  [& [api]]
  (if-let [result (case api
                    "lead_verify" (lv/run-request)
                    "identity_check" (idc/run-request)
                    "caller_identification" (cid/run-request)
                    nil)]
    (pp/pprint result)
    (println "Undefined API")))
