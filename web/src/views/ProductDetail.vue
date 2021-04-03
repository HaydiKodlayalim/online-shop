<template>
  <div class="container shopping-cart">
    <div class="content">
      <h3>{{ productDetail.name }}</h3>

      <div class="row">
        <div class="col-md-12 col-lg-12">
          <div class="row">
            <div class="col-md-5">
              <image-carousel v-bind:images=productDetail.images></image-carousel>
            </div>
            <div class="col-md-7">
              <features v-bind:productFeatures="productDetail.features"></features>
            </div>
          </div>
          <hr>
        </div>
      </div>

      <div class="row">
        <description v-bind:description="productDetail.description"></description>
      </div>

      <div class="row">
        <comments v-bind:productId="productDetail.id"></comments>
      </div>
    </div>
  </div>
</template>

<script>
import Features from "@/components/product-detail/features";
import Description from "@/components/product-detail/description";
import Comments from "@/components/product-detail/comments";
import ImageCarousel from "@/components/product-detail/image-carousel";
import {getProductDetailById} from "@/common/product.service";

export default {
  name: 'ProductDetailComponent',
  components: {ImageCarousel, Comments, Description, Features},
  data() {
    return {productDetail: {}}
  },
  mounted() {
    getProductDetailById(this.$route.params.id).then(response => {
      this.productDetail = response.data;
    });
  }
}
</script>


<style scoped lang='scss'>

</style>
