import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Home from '@/components/Home'
import Projects from '@/components/Projects'
import Builder from '@/components/Builder'
import Dictionary from '@/components/Dictionary'
import Register from '@/components/Register'
import About from '@/components/About'
import Login from '@/components/Login'
import Service from '@/components/Service'
import Bootstrap from '@/components/Bootstrap'
import User from '@/components/User'
import store from './store'

Vue.use(Router)

const ifNotAuthenticated = (to, from, next) => {
  if (!store.getters.isAuthenticated) {
    next()
    return
  }
  next('/')
}

const ifAuthenticated = (to, from, next) => {
  if (store.getters.isAuthenticated) {
    next()
    return
  }
  next('/login')
}

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/about',
      name: 'About',
      component: About
    },
    {
        path: '/projects',
        name: 'Projects',
        component: Projects,
        beforeEnter: ifAuthenticated,
    },
    {
        path: '/login',
        name: 'Login',
        component: Login,
        beforeEnter: ifNotAuthenticated
    },
    {
        path: '/builder',
        name: 'Builder',
        component: Builder,
        beforeEnter: ifAuthenticated,
    },
    {
        path: '/dictionary',
        name: 'Dictionary',
        component: Dictionary,
        beforeEnter: ifAuthenticated,
    },
    {
        path: '/register',
        name: 'Register',
        component: Register,
        beforeEnter: ifNotAuthenticated
    },
    {
          path: '/hello',
          name: 'Hello',
          component: Hello
    },
    {
      path: '/callservice',
      name: 'Service',
      component: Service
    },
    {
      path: '/bootstrap',
      name: 'Bootstrap',
      component: Bootstrap
    },
    {
      path: '/user',
      name: 'User',
      component: User
    }
  ]
})
