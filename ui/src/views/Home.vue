<template>
  <div>
    <p>API status:</p>
    <p>{{ status }}</p>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import Component from "vue-class-component";
import ApiStatus from "@/model/ApiStatus";

@Component
export default class Home extends Vue {
  status: ApiStatus | null = null;

  async created(): Promise<void> {
    this.status = (await this.$api.getStatus()).data;
  }
}
</script>
