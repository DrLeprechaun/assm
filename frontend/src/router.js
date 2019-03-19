import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Home from '@/components/Home'
import Projects from '@/components/Projects'
import Assm from '@/components/Assm'
import Dictionary from '@/components/Dictionary'
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
        path: '/assm',
        name: 'Assm',
        component: Assm
    },
    {
        path: '/dictionary',
        name: 'Dictionary',
        component: Dictionary
    },
    {
        path: '/register',
        name: 'Register',
        component: Register
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
