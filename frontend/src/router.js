import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Home from '@/components/Home'
import Account from '@/components/Account'
import Projects from '@/components/Projects'
import Builder from '@/components/Builder'
import Dictionary from '@/components/Dictionary'
import Users from '@/components/Users'
import Register from '@/components/Register'
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
      path: '/account',
      name: 'Account',
      component: Account
    },
    {
      path: '/about',
      name: 'About',
      component: About
    },
    {
        path: '/projects',
        name: 'Projects',
        component: Projects
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/builder',
        name: 'Builder',
        component: Builder
    },
    {
        path: '/dictionary',
        name: 'Dictionary',
        component: Dictionary
    },
    {
      path: '/users',
      name: 'Users',
      component: Users
    },
    {
        path: '/register',
        name: 'Register',
        component: Register
    }
    /*{
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
    }*/
  ]
})
