(ns code-examples.core-test
  (:require [clojure.test :refer :all]
            [code-examples.identity-check :as idc]
            [code-examples.lead-verify :as lv]))

(deftest a-test
  (testing "Identity check shall return a coll with 8 items"
    (is (= 8 (count (idc/run-request)))))
  (testing "Lead verify shall return a coll with 5 items"
    (is (= 5 (count (lv/run-request))))))
