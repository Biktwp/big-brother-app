package com.bigbrother

sealed class Result<T> {
    class Success<T>(val value: T) : Result<T>()
    class Failure<T>(val exception: Throwable? = null) : Result<T>()

    inline fun <R> mapSuccess(transformation: (T) -> R): Result<R> {
        return when (this) {
            is Success -> Success(transformation.invoke(value))
            is Failure -> Failure(exception)
        }
    }

    inline fun mapFailure(failure: (Throwable?) -> Throwable?): Result<T> {
        return when (this) {
            is Success -> Success(value)
            is Failure -> Failure(failure.invoke(exception))
        }
    }

    inline fun <R> onSuccess(success: (T) -> Result<R>): Result<R> {
        return when (this) {
            is Failure -> Failure(exception)
            is Success -> success.invoke(value)
        }
    }

    inline fun onFailure(failure: (Throwable?) -> Throwable?): Result<T> {
        return this.apply { if (this is Failure) failure.invoke(exception) }
    }

}
