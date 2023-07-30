<template>
  <div id="container"></div>
</template>

<script>

import AMapLoader from '@amap/amap-jsapi-loader';

export default {
  name: "Map",
  data() {
    return {
      //此处不声明 map 对象，可以直接使用 this.map赋值或者采用非响应式的普通对象来存储。
      //map:null,
    }
  },
  mounted() {
    //DOM初始化完成进行地图初始化
    this.initMap();
  },
  methods: {
    initMap() {
      AMapLoader.load({
        key: "2ecd59b5c5e0d67b03d5204d6f63219d",             // 申请好的Web端开发者Key，首次调用 load 时必填
        version: "2.0",      // 指定要加载的 JSAPI 的版本，缺省时默认为 1.4.15
        plugins: [''],       // 需要使用的的插件列表，如比例尺'AMap.Scale'等
      }).then((AMap) => {
        this.map = new AMap.Map("container", {  //设置地图容器id
          viewMode: "2D",    //是否为3D地图模式
          zoom: 13,           //初始化地图级别
          center: [116.397428, 39.90923], //初始化地图中心点位置
        });

        // 创建一个 Marker 实例：
        const marker = new AMap.Marker({
          position: new AMap.LngLat(116.39, 39.9),   // 经纬度对象，也可以是经纬度构成的一维数组[116.39, 39.9]
          title: '北京'
        });

        // 将创建的点标记添加到已有的地图实例：
        this.map.add(marker);
      }).catch(e => {
        console.log(e);
      })
    },
  },
}
</script>

<style scoped>
#container {
  padding: 0px;
  margin: 0px;
  width: 100%;
  height: 800px;
}
</style>
