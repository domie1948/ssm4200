import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import chongwuxinxi from '@/views/modules/chongwuxinxi/list'
    import news from '@/views/modules/news/list'
    import shangpinxinxi from '@/views/modules/shangpinxinxi/list'
    import storeup from '@/views/modules/storeup/list'
    import zaixianguahao from '@/views/modules/zaixianguahao/list'
    import zaixianmenzhen from '@/views/modules/zaixianmenzhen/list'
    import yonghu from '@/views/modules/yonghu/list'
    import shangpinfenlei from '@/views/modules/shangpinfenlei/list'
    import messages from '@/views/modules/messages/list'
    import orders from '@/views/modules/orders/list'
    import chongwuzhenliao from '@/views/modules/chongwuzhenliao/list'
    import yisheng from '@/views/modules/yisheng/list'
    import config from '@/views/modules/config/list'
    import chongwujiyang from '@/views/modules/chongwujiyang/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/chongwuxinxi',
        name: '宠物信息',
        component: chongwuxinxi
      }
      ,{
	path: '/news',
        name: '通知公告',
        component: news
      }
      ,{
	path: '/shangpinxinxi',
        name: '商品信息',
        component: shangpinxinxi
      }
      ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
      ,{
	path: '/zaixianguahao',
        name: '在线挂号',
        component: zaixianguahao
      }
      ,{
	path: '/zaixianmenzhen',
        name: '在线门诊',
        component: zaixianmenzhen
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/shangpinfenlei',
        name: '商品分类',
        component: shangpinfenlei
      }
      ,{
	path: '/messages',
        name: '留言板管理',
        component: messages
      }
      ,{
        path: '/orders/:status',
        name: '订单管理',
        component: orders
      }
      ,{
	path: '/chongwuzhenliao',
        name: '宠物诊疗',
        component: chongwuzhenliao
      }
      ,{
	path: '/yisheng',
        name: '医生',
        component: yisheng
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/chongwujiyang',
        name: '宠物寄养',
        component: chongwujiyang
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
