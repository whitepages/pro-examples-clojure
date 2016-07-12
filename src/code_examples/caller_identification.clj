(ns code-examples.caller-identification
  (:require [clj-http.client :as client]))

(defn run-request []
  (let [url "https://proapi.whitepages.com/3.0/caller_identification"
        params {:phone   "6464806649",
                :api_key (System/getenv "CALLER_ID_API_KEY")}
        response (client/get url {:query-params params :as :json})]

    (:body response)))
