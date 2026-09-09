(ns kotoba.coll.prewalk
  "prewalk -- one definition, addressed on its own.

  Split out of kotoba.lang.text on 2026-09-09. The unit here is the
  DEFINITION, not the library: this repo holds prewalk and names, in its
  deps.edn, exactly the definitions prewalk reaches. Nothing else."
  (:require [kotoba.coll.walk :refer [walk]]))

(defn prewalk
  "Like `walk`, but apply `f` to `form` and then to its children,
  recursively, top-down (f runs on a node before it runs on that node's
  children). Mirrors clojure.walk/prewalk, unbounded."
  [f form]
  (walk (partial prewalk f) identity (f form)))
