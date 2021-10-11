
#lang racket

(provide (all-defined-out)) ;; so we can put tests in a second file

;; put your code below

;; Problem 1
(define (sequence low high stride)
  (if (> low high) 
      null
      (cons low (sequence (+ low stride) high stride))))

;; Problem 2
(define (string-append-map xs suffix)
  (map (lambda (i) (string-append i suffix)) xs))

;; Problem 3
(define (list-nth-mod xs n)
  (cond [(< n 0)(error "list-nth-mod: negative number")]
        [(null? xs)(error "list-nth-mod: empty list")]
        [else
         (car (list-tail xs (remainder n (length xs))))]))
         
;; Problem 4
(define (stream-for-n-steps s n)
  (cond [(= n 0) null]
        [else
         (cons (car (s)) (stream-for-n-steps (cdr (s)) (sub1 n)))]))

;; Problem 5
(define funny-number-stream
  (letrec ([f (lambda (x) (if [= (remainder x 5) 0]
                              [cons (- x) (lambda () (f (+ x 1)))]
                              [cons x (lambda () (f (+ x 1)))]
                              ))])
  (lambda () (f 1))))

;; Problem 6
(define dan-then-dog
  (letrec ([f (lambda (x) (if (= x 1)
                              (cons "dan.jpg" (lambda () (f (+ x 1))))
                              (cons "dog.jpg" (lambda () (f (- x 1))))
                              ))])
    (lambda () (f 1))))

;; Problem 7
(define (stream-add-zero s)
  (letrec ([f (lambda (x) (cons (cons 0 (car (x))) (lambda () (f (cdr (x))))))])
           (lambda () (f s))))
                              
;; Problem 8
(define (cycle-lists xs ys)
  (letrec ([f (lambda (n) (cons (cons (list-nth-mod xs n)
                                      (list-nth-mod ys n))
                                (lambda () (f (+ n 1)))))])
    (lambda () (f 0))))


;; Problem 9
(define (vector-assoc v vec)
  (letrec ([f (lambda (x)
                (cond [(= x (vector-length vec)) #f]
                      [(pair? (vector-ref vec x)) (let ([p (vector-ref vec x)])
                                                    (cond [(equal? (car p) v) p]
                                                          [else
                                                           (f (+ x 1))]))]
                      [else
                       (f (+ x 1))]))])
    (f 0)))

;; Problem 10
(define (cached-assoc xs n)
  (letrec ([vec (make-vector n #f)]
           [pos 0])
    (lambda (v) (let ([cache (vector-assoc v vec)])
                  (cond [(equal? #f cache) (let ([ans (assoc v xs)])
                                             (cond [(equal? ans #f) #f]
                                                   [else
                                                    (begin (vector-set! vec pos ans)
                                                           (set! pos (if (= pos (- n 1))
                                                                         0
                                                                         (+ pos 1)))
                                                           ans)]))]
                        [else
                              cache])))))
  
;; Problem 11
(define-syntax while-less
  (syntax-rules (do)
    [(while-less e1 do e2)
     (letrec ([x e1]
              [iteration (lambda (y) (if (< y x)
                                         (iteration e2)
                                         #t))])
       (iteration e2))]))












                           