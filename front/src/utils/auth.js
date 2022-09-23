    export function setStorage (key, value) {
    window.localStorage.setItem(key, value)
  }
  
  export function getStorage (key) {
    return window.localStorage.getItem(key)
  }
  
  export function clearStorage () {
    return window.localStorage.clear()
  }