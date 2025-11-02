-- =====================================================
-- Schema: ecommerce
-- =====================================================

DROP SCHEMA IF EXISTS ecommerce CASCADE;
CREATE SCHEMA ecommerce;
SET search_path TO ecommerce;

-- =====================================================
-- Table: product_category
-- =====================================================

CREATE TABLE IF NOT EXISTS product_category (
    id BIGSERIAL PRIMARY KEY,
    category_name VARCHAR(255)
);

-- =====================================================
-- Table: product
-- =====================================================

CREATE TABLE IF NOT EXISTS product (
    id BIGSERIAL PRIMARY KEY,
    sku VARCHAR(255),
    name VARCHAR(255),
    description TEXT,
    unit_price NUMERIC(13,2),
    image_url VARCHAR(255),
    active BOOLEAN DEFAULT TRUE,
    units_in_stock INTEGER,
    date_created TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP,
    last_updated TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP,
    category_id BIGINT NOT NULL REFERENCES product_category(id)
);

-- =====================================================
-- Sample Data
-- =====================================================

INSERT INTO product_category (category_name)
VALUES ('BOOKS');

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES 
('BOOK-TECH-1000', 'JavaScript - The Fun Parts', 'Learn JavaScript',
 'assets/images/products/placeholder.png', TRUE, 100, 19.99, 1, NOW()),
('BOOK-TECH-1001', 'Spring Framework Tutorial', 'Learn Spring',
 'assets/images/products/placeholder.png', TRUE, 100, 29.99, 1, NOW()),
('BOOK-TECH-1002', 'Kubernetes - Deploying Containers', 'Learn Kubernetes',
 'assets/images/products/placeholder.png', TRUE, 100, 24.99, 1, NOW()),
('BOOK-TECH-1003', 'Internet of Things (IoT) - Getting Started', 'Learn IoT',
 'assets/images/products/placeholder.png', TRUE, 100, 29.99, 1, NOW()),
('BOOK-TECH-1004', 'The Go Programming Language: A to Z', 'Learn Go',
 'assets/images/products/placeholder.png', TRUE, 100, 24.99, 1, NOW());
