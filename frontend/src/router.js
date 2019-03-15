import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Home from '@/components/Home'
import Builder from '@/components/Builder'
import Assm from '@/components/Assm'
import About from '@/components/About'
import Login from '@/components/Login'
import Service from '@/components/Service'
import Bootstrap from '@/components/Bootstrap'
import User from '@/components/User'

Vue.use(Router)

export default new Router({
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
        path: '/builder',
        name: 'Builder',
        component: Builder
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/assm',
        name: 'Assm',
        component: Assm
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
