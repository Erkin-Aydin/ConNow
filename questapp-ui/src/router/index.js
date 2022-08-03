import VueRouter from "vue-router";
import Home from "../components/HomeView";
import Comment from "../components/CommentView";
import Post from "../components/PostView";
import User from "../components/UserView";
import Login from "@/components/LoginView";
import Vue from "vue";
//import Vue from "vue/types/index";

Vue.use(VueRouter)

const routes = [
    {path: '/login', component: Login},
    {path: '/', component: Home},
    {path: '/comment', component: Comment},
    {path: '/posts', component: Post},
    {path: '/users', component: User}
]

const router = new VueRouter({
    routes
})

export default router