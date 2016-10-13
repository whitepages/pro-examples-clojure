(ns code-examples.phone-search
  (:require [clj-http.client :as client]))

(defn run-request []
  (let [url "https://proapi.whitepages.com/3.0/phone"
        params {:phone   "6464806649",
                :api_key (System/getenv "PHONE_SEARCH_API_KEY")}
        response (client/get url {:query-params params :as :json})]

    (:body response)))
