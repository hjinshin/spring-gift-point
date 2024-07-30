package gift.controller.restcontroller;

import gift.controller.dto.request.ProductRequest;
import gift.controller.dto.response.OptionResponse;
import gift.controller.dto.response.PagingResponse;
import gift.controller.dto.response.ProductResponse;
import gift.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Tag(name = "Product", description = "상품 API")
@RestController
@RequestMapping("/api")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    @Operation(summary = "전체 상품 조회", description = "전체 상품을 조회합니다.")
    public ResponseEntity<PagingResponse<ProductResponse.WithOption>> getProducts(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        PagingResponse<ProductResponse.WithOption> responses = productService.findAllProductPaging(pageable);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/products/{id}")
    @Operation(summary = "상품 조회", description = "특정 상품을 조회합니다.")
    public ResponseEntity<ProductResponse.Info> getProduct(
            @PathVariable("id") @NotNull @Min(1) Long id
    ) {
        ProductResponse.Info response = productService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/products")
    @Operation(summary = "상품 추가", description = "상품을 추가합니다.")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createProduct(
            @Valid @RequestBody ProductRequest.CreateProduct request
    ) {
        Long id = productService.save(request.toDto());
        return ResponseEntity.created(URI.create("/api/v1/product" + id)).body(id);
    }

    @PutMapping("/products")
    @Operation(summary = "상품 수정", description = "상품을 수정합니다.")
    public ResponseEntity<Void> updateProduct(
            @Valid @RequestBody ProductRequest.UpdateProduct request
    ) {
        productService.updateProduct(request.toDto());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/products/{id}")
    @Operation(summary = "상품 삭제", description = "상품을 삭제합니다.")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable("id") @NotNull @Min(1) Long id
    ) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/category/{id}/products")
    @Operation(summary = "카테고리에 해당하는 상품 조회", description = "카테고리에 해당하는 상품을 조회합니다.")
    public ResponseEntity<List<ProductResponse.Info>> getProductsByCategoryId(
            @PathVariable("id") @NotNull @Min(1) Long id
    ) {
        List<ProductResponse.Info> responses = productService.findProductsByCategoryId(id);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/products/{id}/options")
    @Operation(summary = "상품 옵션 조회", description = "상품의 옵션을 조회합니다.")
    public ResponseEntity<List<OptionResponse>> getOptions(
            @PathVariable("id") @NotNull @Min(1) Long id
    ) {
        List<OptionResponse> options = productService.getAllOptions(id);
        return ResponseEntity.ok().body(options);
    }
}
